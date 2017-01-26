#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char array[80];
    int i;
    int length;
    char k;
    int ret;

    printf("Enter string\n");
    scanf("%s", array);

    printf("Which letter you want to correct\n");
    scanf("%s", k);

    length=strlen(array);

    for(i=0;i<length;i++)
    {
        ret=strcmp(array,k);

        if(ret==1)
        {
            array[i]=k;
        }
    }
    for(i=0;i<length;i++)
    {
        printf("%s", array[i]);

    }

    return 0;
}

