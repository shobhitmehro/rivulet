#include "producer.h"
#include "network.h"
#include <stdio.h>
#include <stdlib.h>

void producer_send(const char *event, const char *host, int port) {
    printf("[Producer] Sending event: %s to %s:%d\n", event, host, port);
    network_send(host, port, event);
}
