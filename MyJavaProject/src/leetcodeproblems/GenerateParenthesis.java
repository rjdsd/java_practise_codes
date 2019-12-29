// https://leetcode.com/problems/generate-parentheses/

import java.util.*;

class GenerateParenthesis {
    ArrayList<String> strList = new ArrayList<>();
    

    public List<String> generateParenthesis(int n) {
        strList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        _generate_list(sb, n, 0, 0, 0);
        return strList;
    }
    
    private void _generate_list(StringBuilder sb, int n, int pos, int open, int       close) {
        //System.out.println(sb.toString());
        if(close > open){
            return;
        }
        if(pos == 2*n && open == close){
            strList.add(sb.toString());
        }
        if(pos < 2*n) {
            sb.append("(");
            _generate_list(sb,n,pos+1,open+1,close);
            sb.deleteCharAt(pos);
            sb.append(")");
            _generate_list(sb,n,pos+1,open,close+1);
            sb.deleteCharAt(pos);
        }
    }
}