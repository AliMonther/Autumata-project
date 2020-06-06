/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectautumata;

/**
 *
 * @author ASUS
 */
public class DFA {

    public state states[];
    public int table[][];
    public char alphabet[];

    public DFA(int numOfStates, int finalStates[], char alpha[], int Table[][]) {
        states = new state[numOfStates];
        for (int i = 0; i < numOfStates; i++) {
            states[i] = new state(false);
        }
        for (int i = 0; i < finalStates.length; i++) {
            states[finalStates[i]].isFinal = true;
        }

        alphabet = new char[alpha.length];
        for (int i = 0; i < alpha.length; i++) {
            alphabet[i] = alpha[i];
        }
        //alphabet=alpha;

        table = Table;
    }

    public void printDFA() {
        //لطباعة أرقام الحالات وحالة كل حالة منها اذا كانت نهائية ام لا
        for (int i = 0; i < states.length; i++) {
            System.out.println(i + " " + states[i].isFinal);
        }
        //لطباعة الأبجدية
        for (int i = 0; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + "  ");
        }
        System.out.print("\n");

        //لطباعة جدول الانتقالات
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.print("\n");

        }
    }

    //تابع ليختير انتماء محرف الى الابجدية

    public boolean testBelongingChartoAlpha(char c) {
        int w = alphabet.length;

        for (int i = 0; i < alphabet.length; i++) {
            if (c == alphabet[i]) {
                w++;
            }
        }

        if (w == alphabet.length) {
            return false;
        } else {
            return true;
        }

    }

    public boolean testString(char word[]) {

        int index = 0;
        state temp = states[index];

        for (int i = 0; i < word.length; i++) {

            for (int j = 0; j < alphabet.length; j++) {
                if (!testBelongingChartoAlpha(word[i])) {
                    return false;
                }
                if (word[i] == alphabet[j]) {
                    temp = states[table[index][j]];
                    index = table[index][j];
                }
            }
        }
        

        return temp.isFinal;
    }
}
