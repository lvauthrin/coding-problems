class EditDistance {
  public int minDistance(String word1, String word2) {
    var cost = new int[word1.length() + 1][word2.length() + 1];
    cost[0][0] = 0;

    for (int i = 1; i < cost.length; i++) {
      cost[i][0] = cost[i - 1][0] + 1;
    }

    for (int i = 1; i < cost[0].length; i++) {
      cost[0][i] = cost[0][i - 1] + 1;
    }

    for (int i = 1; i < cost.length; i++) {
      for (int j = 1; j < cost[0].length; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          cost[i][j] = cost[i - 1][j - 1];
        } else {
          cost[i][j] = Math.min(Math.min(
              cost[i][j - 1],
              cost[i - 1][j]), cost[i - 1][j - 1]) + 1;
        }
      }
    }

    return cost[word1.length()][word2.length()];
  }
}

/*
 * 
 * 
 * 
 * h o r s e
 * h
 * o
 * r
 * s
 * e
 * 
 */
