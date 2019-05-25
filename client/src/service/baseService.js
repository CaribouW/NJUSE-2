export function dealResponse(response) {
  const body = response.data;
  if (body.status === 200)
    return body.data;
  else
    return body.status;
}
