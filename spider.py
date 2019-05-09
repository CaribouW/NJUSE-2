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
    pattern = re.compile(
        '<dd>.*?board-index.*?>(.*?)</i>.*?data-src="(.*?)".*?name.*?a.*?>(.*?)</a>'
        + '.*?star">(.*?)</p>.*?releasetime">(.*?)</p>.*?integer">(.*?)</i>.*?fraction">'
        + '(.*?)</i>.*?</dd>', re.S
    )
    items = re.findall(pattern, html)
    for item in items:
        yield {
            'index': item[0],
            'image': item[1],
            'title': item[2].strip(),
            'actor': item[3].strip()[3:] if len(item[3]) > 3 else '',
            'time': item[4].strip()[5:] if len(item[4]) > 5 else '',
            'score': item[5].strip() + item[6].strip()
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
    sql = "INSERT INTO movie_info(movie_id,name,poster,score)\
      VALUES ('%s','%s','%s',%s)" % (str(movie['index']), movie['title'], movie['image'], movie['score'])
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
