#include <stdio.h>
#include <stdlib.h>


void check(int array[], int a)
{
   int *ptr, i, k=0;
   ptr=&a;

   for(i=0;i<6;i++)
   {
       if(array[i]==*ptr);
       {
           k++;
       }
   }
   printf("%d", k);


}

int main()
{
    int array[6];
    int i;
    int a;

    for(i=0;i<6;i++)
    {
        printf("Give a number\n");
        scanf("%d", &array[i]);
    }
    printf("\n");

    for(i=0;i<6;i++)
    {
        printf("%d\n", array[i]);
    }

    printf("\nWhich number you want to count\n");
    scanf("%d", &a);

    check(array[i], a);

    return 0;
}
