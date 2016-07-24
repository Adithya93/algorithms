#include <stdlib.h>
#include <stdio.h>

int nearestInt(int num) {
    int rightMostSetBit = num & ~(num - 1);
    if (rightMostSetBit == 1) {
        return ~nearestInt(~num);
    }
    return (num ^ rightMostSetBit) | (rightMostSetBit >> 1);
}

int main(int argc, char * argv[]) {
    if (argc < 2) {
        puts("Usage : ./nearestInt <num>");
        exit(1);
    }
    int num = atoi(argv[1]);
    printf("Nearest integer to %d with same weight is %d\n", num, nearestInt(num));
    exit(0);
}
