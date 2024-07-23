class Solution
{
    public int solution(int n, int a, int b)
    {
        int i=0;
        while(a != b){
            i++;
            a = (int)Math.ceil((double)a / 2);
            b = (int)Math.ceil((double)b / 2);
        }

        return i;
    }
}