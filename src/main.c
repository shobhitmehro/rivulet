#include "broker.h"
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    int port = 9000;
    if (argc > 1) {
        port = atoi(argv[1]);
    }
    printf("Rivulet Broker starting on port %d\n", port);
    broker_start(port);
    return 0;
}
