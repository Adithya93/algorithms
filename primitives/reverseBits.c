#include <stdio.h>
#include <stdlib.h>
#include <string.h>

long reverseBits(long num) {
    long reverse = 0;
    int pow = 0;
    while (pow < 64) {
        reverse |= ((num & (1 << pow)) << (63-pow - pow));
        pow ++;
    }
    return reverse;
}


int main(int argc, char *argv[]) {
    if (argc < 2) {
        puts("Usage: ./reverseBits <num>");
        exit(1);
    }
    long num = strtol(argv[1], NULL, 10);
    printf("Reverse of %ld is %ld\n", num, reverseBits(num));
    exit(0);
}
