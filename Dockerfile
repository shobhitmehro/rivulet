FROM gcc:13-alpine
WORKDIR /app
COPY . .
RUN make
EXPOSE 9000
CMD ["bin/rivulet", "9000"]
