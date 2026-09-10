class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        int i=0;
        while(i < path.length()){
            while(i < path.length() && path.charAt(i) == '/')
               i++;
            if(i == path.length())
               break;
            int j = i;
            while(j < path.length() && path.charAt(j) != '/')
                j++;
            String part = path.substring(i, j);
            if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            }else if(!part.equals(".")){
                stack.addLast(part);
            }
            i = j;
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append("/");
            result.append(stack.pollFirst());
        }
        return result.toString();
    }
}