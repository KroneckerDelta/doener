#!/bin/sh
set -e
echo $@

/usr/bin/mysqld_safe &
 java -jar /usr/share/doener/god-doener.jar