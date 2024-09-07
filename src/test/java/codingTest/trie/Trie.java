package codingTest.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    /**
     * 트라이를 이용한 자동 완성 ( 트라이란? 공통 접두어를 기준으로 밑에 tree에서 단어 찾기 )
     * @param args
     */
    public static String[] words = {"go","gone","guild"};

    public static void main(String[]args){

        TrieNew myTrie = new TrieNew();
        for(String str : words)
            myTrie.insert(str);

        int answer = 0;
        for(String str : words)
            answer += myTrie.getMinTypingCount(str);

       System.out.println(answer);

    }

    static class TrieNode{
        public Map<Character, TrieNode> childNodes = new HashMap(); // 하위 문자 관리
        public int count; // 하위 단어들의 수
        public boolean isLast; // 마지막 문자인가?
    }
    static class TrieNew{
        TrieNode root;

        TrieNew(){
            root = new TrieNode();
        }

        void insert(String word){
            TrieNode node = this.root; // 단어를 넣을떄 마다 기준을 root 부터

            // 첫번째 문자부터 하위로 가면서, 파생단어의 수와 마지막 단어임을 기록
            for (int i = 0; i < word.length(); i++){
                node.count++;
                //자식에 글자가 있으면 쓰고 없으면 만들어줌. computeIfAbsent
                //기준을 자식 노드로 변경
                node = node.childNodes.computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            node.count++;
            node.isLast = true;
        }

        int getMinTypingCount(String word){
            TrieNode node = this.root;

            int length = word.length();
            int last = length;

            for (int i = 0; i < length; i++){
                // 남은 하위 단어가 1개라면, 현재 입력으로 결정된다
                if(node.count == 1){
                    last = i;
                    break;
                }
                node = node.childNodes.get(word.charAt(i));
            }
            return last;
        }

    }




}
