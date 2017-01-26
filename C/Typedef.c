#include <stdio.h>
#include <stdlib.h>


typedef struct
{
    char product[80];
    int number;
    int hinta;
}article;

int main()
{
    int *k;
    int koko;
    int i;
    char temp[30];
    printf("How many products?\n");
    scanf("%d", &koko);
    k=malloc(koko*sizeof(int));

    if(k==NULL)
    {
        printf("Not enough space");
        return 1;
    }

    for(i=0;i<koko;i++)
    {
        printf("Name\n");
        gets(&k[i].product[0]);

        printf("Product number\n");
        gets(temp);
        k[i].number=atoi(temp);

        printf("Price\n");
        gets(temp);
        k[i].hinta=atoi(temp);

    }

    free(k);



    return 0;
}
