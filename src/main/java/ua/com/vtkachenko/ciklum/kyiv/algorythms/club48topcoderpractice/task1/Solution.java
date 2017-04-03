package ua.com.vtkachenko.ciklum.kyiv.algorythms.club48topcoderpractice.task1;

// PROBLEM STATEMENT
// A girl would like to go out with one of her favorite boys, but she does not know which one to choose.  Fortunately, she has a Love Calculator which can
// calculate the probability of love between two people.  Love Calculator takes two people's names and uses the following algorithm to calculate the
// probability of love between them:

//        L := the total number of occurrences of the letter 'L' in both names.
//        O := the total number of occurrences of the letter 'O' in both names.
//        V := the total number of occurrences of the letter 'V' in both names.
//        E := the total number of occurrences of the letter 'E' in both names.

//        The percent probability of love is equal to ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E))%100, where % is the modulo operator.
//        You are given a String girl containing the girl's name, and a String[] boys containing her favorite boys' names.  Return the name of the boy with which the girl has the highest probability of love.  If there is more than one such boy, return the one among them that comes earliest alphabetically.
//        DEFINITION
//        Class:LoveCalculator
//        Method:findBoy
//        Parameters:String, String[]
//        Returns:String
//        Method signature:String findBoy(String girl, String[] boys)
//        CONSTRAINTS
//        -girl will contain between 1 and 20 uppercase letters ('A'-'Z'), inclusive.
//        -boys will contain between 1 and 50 elements, inclusive.
//        -Each element of boys will contain between 1 and 20 uppercase letters ('A'-'Z'), inclusive.
//        EXAMPLES
//        0)
//        "LOVE"
//        {"JACOB","FRANK","DANO"}
//        Returns: "FRANK"
//        The highest probability is 64 percent, and it is achieved with FRANK.  The probabilities for JACOB and DANO are both 16 percent.
//        1)
//        "JANE"
//        {"THOMAS","MICHAEL","INDY","LIU"}
//        Returns: "INDY"
//        The probability of love is 0 percent for all the boys.  Among them, INDY comes first alphabetically.
//        2)
//        "LILLY"
//        {"PIERRE"}
//        Returns: "PIERRE"
//        3)
//        "MERYLOV"
//        {"JOHN","DAVE","STEVE","JOHN","DAVE"}
//        Returns: "DAVE"
//        4)
//        "LLOL"
//        {"BVERON","CVERON","AVERON","DVERON"}
//        Returns: "AVERON"
//        5)
//        "VELYLEOCEVE"
//        {"YVXHOVE","LCOKO","OGWSJVEVEDLE","WGFVSJEL","VLOLUVCBLLQVESWHEEKC"}
//        Returns: "VLOLUVCBLLQVESWHEEKC"
//        */
// END CUT HERE
public class Solution {
    public static void main(String[] args) {
        LoveCalculator loveCalculator = new LoveCalculator();
        System.out.println(loveCalculator.findBoy("LOVE", new String[]{"JACOB", "FRANK", "FRANKLOVE"}));
    }


}

class LoveCalculator{
    public String findBoy(String girl, String[] boys){
        int maxp = -1;
        String result = "";
        for (int i = 0; i < boys.length; i++) {
            String str = boys[i] + girl;
            int l = 0;
            int o = 0;
            int v = 0;
            int e = 0;
            for (int j = 0; j < boys[i].length(); j++) {
                l += str.charAt(j) == 'L' ? 1 : 0;
                o += str.charAt(j) == 'O' ? 1 : 0;
                v += str.charAt(j) == 'V' ? 1 : 0;
                e += str.charAt(j) == 'E' ? 1 : 0;
            }

            int p = ((l+o)*(l+v)*(l*v)*(o+v)*(o+e)*(v+e))%100;
            if (p > maxp){
                maxp = p;
                result = boys[i];
            } else if (p == maxp && result.compareTo(boys[i]) > 0){
                result = boys[i];
            }
        }
        return result;
    }
}
