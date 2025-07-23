#include "consumer.h"
#include <stdio.h>

void consumer_receive(const char *event) {
    printf("[Consumer] Received event: %s\n", event);
}
