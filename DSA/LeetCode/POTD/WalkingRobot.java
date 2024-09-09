import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WalkingRobot {
    public static int robotSim (int[] commands, int[][] obstacles) {

        int x = 0, y = 0, flag = 0, max_X = Integer.MIN_VALUE, max_Y = Integer.MIN_VALUE;
        char dir = 'o', prevDir = 'o';


        for (int i = 0, k = 0; i < commands.length - 1; i++) {

            try {
                int m = obstacles[k][0];
            } catch (Exception e) {
                obstacles = null;
            }
            if (commands[i] >= 0 && i == 0) {
                y = commands[i];
                dir = 'n';
                prevDir = 'n';
            } else if (commands[i] < 0 && i == 0) {
                y = x = 0;
                dir = 'o';
                prevDir = 'o';
            }
            if (commands[i] < 0) {
                if ((dir == 'o' && commands[i] == -1))
                    dir = 'e';
                else if (dir == 'o' && commands[i] == -2)
                    dir = 'w';
                else if ((dir == 'n' && commands[i] == -1) || (dir == 's' && commands[i] == -2))
                    dir = 'e';
                else if ((dir == 'n' && commands[i] == -2) || (dir == 's' && commands[i] == -1))
                    dir = 'w';
                else if ((dir == 'w' && commands[i] == -1) || (dir == 'e' && commands[i] == -2))
                    dir = 'n';
                else if ((dir == 'w' && commands[i] == -2) || (dir == 'e' && commands[i] == -1))
                    dir = 's';
            }

            if (commands[i + 1] >= 0) {
                if ((prevDir == 'n' && dir == 's') || (prevDir == 'e' && dir == 's') || (prevDir == 'w' && dir == 's')) {

                    y -= commands[i + 1];
                    int val = getObs(y, obstacles, 'y');
                    System.out.println("VAl 1 : " + val);
                    if (obstacles != null && obstacles[k] != null && k < obstacles.length && val != Integer.MIN_VALUE && y < val) {
                        y = (val + 1);
                        if (y < val)
                            y++;
                        flag += 1;
                    }
                } else if ((prevDir == 's' && dir == 'n') || (prevDir == 'e' && dir == 'n') || (prevDir == 'w' && dir == 'n')) {
                    y += commands[i + 1];
                    int val = getObs(y, obstacles, 'y');
                    System.out.println("PrevDir : " + prevDir + " , Dir : " + dir);
                    System.out.println("y : " + y);
                    System.out.println("VAL 2 : " + val);
                    if (obstacles != null && obstacles[k] != null && k < obstacles.length && val != Integer.MIN_VALUE && y > val) {
                        y = (val - 1);
                        if (y > val)
                            y--;
                        flag += 1;
                    }
                } else if ((prevDir == 'e' && dir == 'w') || (prevDir == 'n' && dir == 'w') || (prevDir == 's' && dir == 'w')) {
                    x -= commands[i + 1];

                    int val = getObs(x, obstacles, 'x');
                    System.out.println("VAL 3 : " + val);
                    if (obstacles != null && obstacles[k] != null && k < obstacles.length && val != Integer.MIN_VALUE && x < val) {
                        x = (val + 1);
                        if (x < val)
                            x--;
                        flag += 1;
                    }
                } else if ((prevDir == 'w' && dir == 'e') || (prevDir == 'n' && dir == 'e') || (prevDir == 's' && dir == 'e')) {
                    x += commands[i + 1];

                    int val = getObs(x, obstacles, 'x');
                    System.out.println("VAl 4 : " + val);
                    if (obstacles != null && obstacles[k] != null && k < obstacles.length && val != Integer.MIN_VALUE && x > val) {
                        x = (val - 1);
                        if (x > val)
                            x--;
                        flag += 1;
                    }
                }


            }
            System.out.println("Flag : " + flag);
            if (flag >= 1) {
                flag = 0;
                k++;
            }

            prevDir = dir;
            if (max_X < x) max_X = x;
            if (max_Y < y) max_Y = y;
            System.out.println(x + " " + y);
        }
//        if(max_X<0 ||max_Y<0)return 0;
        return (int) (Math.pow(max_X, 2) + Math.pow(max_Y, 2));
    }

    public static int getObs (int k, int[][] obs, char var) {

        if (var == 'y' && obs != null) {
            int val = k;
//                System.out.println("Here inside 1"); (k > 0 && obs[i][1] <= k)
            if ((k < 0)) {

                for (int i = 0; i < obs.length; i++) {
                    if (val < obs[i][1] && obs[i][1] <= 0) val = obs[i][1];
                }
                return val;
            } else if (k > 0) {
                for (int i = 0; i < obs.length; i++) {
                    if (val > obs[i][1] && obs[i][1] >= 0) val = obs[i][1];
                }
                return val;
            }
        } else if (var == 'x' && obs != null) {
            int val = k;
            if ((k < 0)) {

                for (int i = 0; i < obs.length; i++) {
                    if (val < obs[i][0] && obs[i][0] <= 0) val = obs[i][0];
                }
                return val;
            } else if (k > 0) {
                for (int i = 0; i < obs.length; i++) {
                    if (val > obs[i][0] && obs[i][0] >= 0) val = obs[i][0];
                }
                return val;
            }

        }
        return Integer.MIN_VALUE;
    }

    
    // Optimal and working
    public static int robotWalk (int[] commands, int[][] obstacles) {
    

    int x = 0, y = 0, d = 0;
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int maxDistance = 0;
    Set<String> obstacleSet = new HashSet<>();
        for(
    int[] obstacle:obstacles)

    {
        obstacleSet.add(obstacle[0] + "," + obstacle[1]);
    }
        for(
    int cmd:commands)

    {
        if (cmd == -1) {
            d = (d + 1) % 4;
        } else if (cmd == -2) {
            d = (d + 3) % 4;
        } else {
            for (int i = 0; i < cmd; i++) {
                int nx = x + direction[d][0];
                int ny = y + direction[d][1];
                if (obstacleSet.contains(nx + "," + ny)) {
                    break;
                }
                x = nx;
                y = ny;
                maxDistance = Math.max(maxDistance, x * x + y * y);
            }
        }
    }
        return maxDistance;
}
    public static void main (String[] args) {
//
//        int[] a={-2,-1,4,7,8};
//        int[][] obs={{1,1},{2,1},{4,4},{5,-5},{2,-3},{-2,-3},{-1,-3},{-4,-1},{-4,3},{5,1}};
//        
//        System.out.println((robotSim(a,obs)));
        String val="value1";
        StringBuffer str = new StringBuffer();
        str.append(val);
        System.out.println(Math.abs(-1));
        val=val.concat("value2");
        System.out.println(val);
    }
}
