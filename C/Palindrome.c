#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char str [80];
    int length;
    int i;
    int flag=0;


    printf("Enter string\n");
    scanf("%s", str);

    length = strlen(str);

    for(i=0; i<length; i++)
    {
        if(str[i] != str[length-i-1])
        {
            flag=1;
            break;
        }
    }
    if(flag)
    {
        printf("given word is not a palidrome");
    }
    else
        
    printf("given word is a palidrome");



    return 0;
}
