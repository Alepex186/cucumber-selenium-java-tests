#!/bin/sh

URL="http://127.0.0.1:5000/parabank/index.htm"
SLEEP_TIME=5


while true; do
    HTTP_CODE=$(curl -L -s -o /dev/null -w "%{http_code}" --connect-timeout 5 --max-time 5 "$URL")

    if [ "$HTTP_CODE" -eq 200 ]; then
        echo "$URL 200 OK"
        break
    else
        echo "$URL respondio $HTTP_CODE. Reintentando en $SLEEP_TIME segundos..."
        sleep $SLEEP_TIME
    fi
done