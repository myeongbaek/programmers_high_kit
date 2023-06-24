package programmers_hash;

import java.util.*;
import java.util.stream.Collectors;
// 베스트앨범
class Hash05 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        // index 별 플레이 수
        HashMap<Integer, Integer> idxPlay = new HashMap<>();
        // 장르 별 전체 플레이 수
        HashMap<String, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < genres.length; i++) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
            idxPlay.put(i, plays[i]);
        }


        // 전체 플레이 수 기준 내림차순으로 장르를 정렬
        List<String> genreSorted = hm.keySet().stream()
                .sorted((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)))
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (String genre : genreSorted) {
            List<Integer> list = new ArrayList<>();
            // { 0, 3, 4 }
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)) list.add(i);
            }
            // 많이 재생되고 고유 번호가 낮은 노래 순서로 정렬한다.
            list = list.stream().sorted((o1, o2) -> {
                if (idxPlay.get(o2) > idxPlay.get(o1)) {
                    return 1;
                } else if (idxPlay.get(o2).equals(idxPlay.get(o1))) {
                    return o1 - o2;
                } else {
                    return -1;
                }
            }).collect(Collectors.toList());
            // 동적 배열에 각 장르 당 최대 2개의 노래 인덱스 저장
            int cnt = 0;
            for (Integer integer : list) {
                result.add(integer);
                if (++cnt == 2) {
                    break;
                }
            }
        }
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
