import requests
import re
import json
import time
import pymysql

from requests.exceptions import RequestException


def get_one_page(url):
    try:
        headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36'
        }
        response = requests.get(url, headers=headers)
        if response.status_code == 200:
            return response.text
        return None
    except RequestException:
        return None


def parse_one_page(html):
    pattern_norm = re.compile(
        '<dd>.*?board-index.*?>(.*?)</i>.*?data-src="(.*?)".*?name.*?a.*?>(.*?)</a>'
        + '.*?star">(.*?)</p>.*?releasetime">上映时间：(.*?)</p>.*?integer">(.*?)</i>.*?fraction">'
        + '(.*?)</i>.*?</dd>', re.S
    )

    pattern = re.compile(
        '"avatar" src="(.*?)".*?name">(.*?)</h3.*?"ellipsis">(.*?)</li>.*?ellipsis">.*?\n(.*?)\n.*?/(.*?)</li>'
        '.*?"ellipsis">(.*?)</li>.*?',
        re.S
    )
    movie_id_list = re.findall(re.compile('<dd>.*?{movieId:(.*?)}.*?</dd>', re.S), html)  # get all of the movie id
    norm_list = re.findall(pattern_norm, html)
    for i, val in enumerate(movie_id_list):
        score = norm_list[i][5].strip() + norm_list[i][6].strip()
        url = 'https://maoyan.com/films/' + str(val)
        html_single = get_one_page(url)
        items = re.findall(pattern, html_single)
        for item in items:
            yield {
                'index': val,  # id
                'image': item[0].strip(),  # 图片url
                'title': item[1].strip(),  # 电影名
                'length': item[4].strip()[:-2],
                'score': score,  # 得分
                'category': item[2],  # 类别
                'nation': item[3].strip(),  # 国家
            }


def write_to_file(content):
    with open('result.txt', 'a', encoding='utf-8') as f:
        f.write(json.dumps(content, ensure_ascii=False) + '\n')


def main(offset):
    url = 'https://maoyan.com/board/4?offset=' + str(offset)
    html = get_one_page(url)
    for item in parse_one_page(html):
        print(item)
        insert_movie(item)
        write_to_file(item)


# 插入多条
def insert_movies(movies):
    db = pymysql.connect(host='106.14.140.93', port=3306, user='root', passwd='lfm', db='SE2', charset='utf8')
    cursor = db.cursor()
    sql = "INSERT INTO original_douban(id,name,actor,release_date,country,rate,comment_count,rank)\
      VALUES (%s,%s,%s,%s,%s,%s ,%s,%s)" % (movies)
    try:
        cursor.execute(sql)
        db.commit()
    except pymysql.Error:
        db.rollback()
    finally:
        cursor.close()
        db.close()


# 插入一条
def insert_movie(movie):
    db = pymysql.connect(host='106.14.140.93', port=3306, user='root', passwd='lfm', db='SE2', charset='utf8')
    cursor = db.cursor()
    sql = "INSERT INTO movie_info(movie_id,name,poster,score,nation,time_length,category)\
      VALUES ('%s','%s','%s','%s','%s','%s','%s')" % (str(movie['index']), movie['title'], movie['image'], movie['score'],movie['nation'],movie['length'],movie['category'])
    try:
        cursor.execute(sql, movie)
        db.commit()
    except pymysql.Error:
        db.rollback()
    finally:
        cursor.close()
        db.close()


if __name__ == '__main__':
    for i in range(10):
        main(offset=i * 10)
        time.sleep(1)
