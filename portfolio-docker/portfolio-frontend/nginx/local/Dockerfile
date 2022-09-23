FROM nginx:stable-alpine

COPY ./dist /usr/share/nginx/html/
COPY nginx.conf /etc/nginx/nginx.conf
COPY default.conf /etc/nginx/conf.d
RUN ls /usr/share/nginx/html/

EXPOSE 80/tcp

CMD ["/bin/sh", "-c", "exec nginx -g 'daemon off;';"]
