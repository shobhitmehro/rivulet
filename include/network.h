#ifndef NETWORK_H
#define NETWORK_H

void network_server_listen(int port);
void network_send(const char *host, int port, const char *msg);

#endif // NETWORK_H
