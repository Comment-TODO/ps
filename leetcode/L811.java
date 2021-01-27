import java.util.*;

class L811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> inputCountMap = new HashMap<>();
        StringTokenizer tokenizer;
        List<String> answer = new ArrayList<>();

        for (String cpdomain : cpdomains) {
            tokenizer = new StringTokenizer(cpdomain);
            int inputCount = Integer.parseInt(tokenizer.nextToken());
            String[] domainToken = tokenizer.nextToken().split("\\.");
            StringBuffer buffer = new StringBuffer();

            for (int i = domainToken.length - 1; i >= 0; i--) {
                if (buffer.length() > 0) buffer.insert(0, '.');
                buffer.insert(0, domainToken[i]);
                inputCountMap.put(buffer.toString(), inputCountMap.getOrDefault(buffer.toString(), 0) + inputCount);
            }
        }

        inputCountMap.forEach((domain, inputCount) -> answer.add(inputCount + " " + domain));

        return answer;
    }
}
