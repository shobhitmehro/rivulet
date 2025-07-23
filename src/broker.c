#include "broker.h"
#include "network.h"
#include <stdio.h>
#include <stdlib.h>

void broker_start(int port) {
    printf("[Broker] Starting on port %d...\n", port);
    network_server_listen(port);
}
