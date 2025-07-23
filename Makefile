CC=gcc
CFLAGS=-Iinclude -Wall -Wextra -O2
SRC=src/main.c src/broker.c src/producer.c src/consumer.c src/network.c
OBJ=$(SRC:.c=.o)
TARGET=bin/rivulet

all: $(TARGET)

$(TARGET): $(SRC)
	@mkdir -p bin
	$(CC) $(CFLAGS) -o $@ $(SRC)

clean:
	rm -rf bin *.o *.out

.PHONY: all clean
