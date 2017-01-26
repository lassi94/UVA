#include <stdio.h>
#include <stdlib.h>

int main()
{
    int *t;
    int koko;
    int i;

    printf("Size of array\n");
    scanf("%d", &koko);
    t=malloc(koko*sizeof(int));


    if(t==NULL)
    {
        printf("Not enough space\n");
        return 1;
    }
    else

    for(i=0;i<koko;i++)
    {
     printf("Give a number to place %d\n", i+1);
     scanf("%d", &t[i]);
    }
    printf("Array:\n");

    for(i=0;i<koko;i++)
    {
        printf("%d\n", t[i]);
    }
    free(t);


    return 0;
}
