/**
 *@author Matthew Scaccia
 *course CIS303
 *@since 3/29/2020
 *@assignment 4b
 *description: Tuple class used to track Ackermann values
 */

public class Tuple{

    private int m;
    private int n;
    private int p;

    public Tuple(int m_, int n_, int p_){
        setM(m_);
        setN(n_);
        setP(p_);
    }
    private void setM(int m_){
        m = m_;
    }

    public void setN(int n_){
        n = n_;
    }

    private void setP(int p_){
        p = p_;
    }

    public int getM(){
        return m;
    }

    public int getN(){
        return n;
    }

    public int getP(){
        return p;
    }
}