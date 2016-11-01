package streetsimulator;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Movement {

    LinkedList<StreetUser> listSU = new LinkedList();
    char[][] board = new char[20][20];
    boolean bum = false;

    private void clear() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'c' && board[i][j] != 'b') {
                    board[i][j] = ' ';
                }
            }
        }
    }

    private void showStreet() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void addToBoard() {
        for (StreetUser su : listSU) {
            board[su.getLocationX()][su.getLocationY()] = su.getSign();
        }
    }

    private boolean crash() {
        boolean isCrashed = false;
        for (StreetUser su : listSU) {
            for (StreetUser su2 : listSU) {
                if (su.getLocationX() == su2.getLocationX() && su.getLocationY() == su2.getLocationY() && su != su2) {
                    isCrashed = true;

                }
            }
        }
        return isCrashed;
    }

    private void createsVehicles() {
        Random r = new Random();
        int x;
        int y;
        for (int i = 0; i < 6; i++) {
            do {
                x = r.nextInt(board.length);
                y = r.nextInt(board[0].length);
            } while (board[x][y] != ' ');
            board[x][y] = 'c';
        }
        for (int i = 0; i < 6; i++) {
            do {
                x = r.nextInt(board.length);
                y = r.nextInt(board[0].length);
            } while (board[x][y] != ' ');
            board[x][y] = 'b';
        }
    }

    private void createPedestrian() {
        Random r = new Random();
        int cord;
        int rand = r.nextInt(4);
        if (rand == 0) {
            do {
                cord = r.nextInt(board.length);
            } while (board[cord][0] != ' ');

            listSU.add(new Pedestrian(cord, 0));     //gora

        } else if (rand == 1) {
            do {
                cord = r.nextInt(board.length);
            } while (board[cord][board[0].length - 1] != ' ');

            listSU.add(new Pedestrian(cord, board[0].length - 1));     //dol        

        } else if (rand == 2) {
            do {
                cord = r.nextInt(board[0].length);
            } while (board[board.length - 1][cord] != ' ');

            listSU.add(new Pedestrian(board.length - 1, cord));                 //prawo

        } else if (rand == 3) {
            do {
                cord = r.nextInt(board[0].length);
            } while (board[0][cord] != ' ');

            listSU.add(new Pedestrian(0, cord));                                     //lewo
        }

    }

    private void move() {
        Random r = new Random();
        int direction;
        int cord;
        boolean isOk = false;
        for (StreetUser su : listSU) {
            do {
                isOk = false;
                direction = r.nextInt(4);
                if (direction == 0) {             //gora
                    cord = su.getLocationY();
                    if (cord - su.getSpeed() > 0) {
                        isOk = true;
                        su.setLocationY(cord - su.getSpeed());

                        if (su instanceof Pedestrian) {
                            if (board[su.getLocationX()][su.getLocationY()] == 'c') {
                                listSU.set(listSU.indexOf(su), new DecoratorCar((Pedestrian) su));
                            } else if (board[su.getLocationX()][su.getLocationY()] == 'b') {
                                listSU.set(listSU.indexOf(su), new DecoratorBike((Pedestrian) su));
                            }

                        }
                        if (su instanceof DecoratorCar || su instanceof DecoratorBike) {
                            bum = true;

                        }

                    }
                } else if (direction == 1) {       //dol
                    cord = su.getLocationY();
                    if (cord + su.getSpeed() < board[0].length) {
                        isOk = true;
                        su.setLocationY(cord + su.getSpeed());

                        if (su instanceof Pedestrian) {
                            if (board[su.getLocationX()][su.getLocationY()] == 'c') {
                                listSU.set(listSU.indexOf(su), new DecoratorCar((Pedestrian) su));
                            } else if (board[su.getLocationX()][su.getLocationY()] == 'b') {
                                listSU.set(listSU.indexOf(su), new DecoratorBike((Pedestrian) su));
                            }

                        }
                        if (su instanceof DecoratorCar || su instanceof DecoratorBike) {
                            bum = true;

                        }

                    }
                } else if (direction == 2) {       //prawo
                    cord = su.getLocationX();
                    if (cord + su.getSpeed() < board.length) {
                        isOk = true;
                        su.setLocationX(cord + su.getSpeed());

                        if (su instanceof Pedestrian) {
                            if (board[su.getLocationX()][su.getLocationY()] == 'c') {
                                listSU.set(listSU.indexOf(su), new DecoratorCar((Pedestrian) su));
                            } else if (board[su.getLocationX()][su.getLocationY()] == 'b') {
                                listSU.set(listSU.indexOf(su), new DecoratorBike((Pedestrian) su));
                            }

                        }
                        if (su instanceof DecoratorCar || su instanceof DecoratorBike) {
                            bum = true;

                        }

                    }
                } else if (direction == 3) {       //lewo
                    cord = su.getLocationX();
                    if (cord - su.getSpeed() > 0) {
                        isOk = true;
                        su.setLocationX(cord - su.getSpeed());

                        if (su instanceof Pedestrian) {
                            if (board[su.getLocationX()][su.getLocationY()] == 'c') {
                                listSU.set(listSU.indexOf(su), new DecoratorCar((Pedestrian) su));
                            } else if (board[su.getLocationX()][su.getLocationY()] == 'b') {
                                listSU.set(listSU.indexOf(su), new DecoratorBike((Pedestrian) su));
                            }

                        }
                        if (su instanceof DecoratorCar || su instanceof DecoratorBike) {
                            bum = true;

                        }

                    }
                }
            } while (!isOk);
        }
    }

    private void off() {
        Random r = new Random();
        for (StreetUser su : listSU) {
            if (r.nextInt(4) == 0) {
                if (su instanceof DecoratorBike) {
                    listSU.set(listSU.indexOf(su), ((DecoratorBike) su).getOff());
                    board[su.getLocationX()][su.getLocationY()] = 'b';
                } else if (su instanceof DecoratorCar) {
                    listSU.set(listSU.indexOf(su), ((DecoratorCar) su).getOff());
                    board[su.getLocationX()][su.getLocationY()] = 'c';
                }
                if (su.getLocationX() > 0 && board[su.getLocationX() - 1][su.getLocationY()] == ' ') {
                    su.setLocationX(su.getLocationX() - 1);
                    su.setLocationY(su.getLocationY());
                } else if (su.getLocationX() < board.length - 1 && board[su.getLocationX() + 1][su.getLocationY()] == ' ') {
                    su.setLocationX(su.getLocationX() + 1);
                    su.setLocationY(su.getLocationY());
                } else if (su.getLocationY() > 0 && board[su.getLocationX()][su.getLocationY() - 1] == ' ') {
                    su.setLocationX(su.getLocationX());
                    su.setLocationY(su.getLocationY() - 1);
                } else if (su.getLocationY() < board[0].length - 1 && board[su.getLocationX()][su.getLocationY() + 1] == ' ') {
                    su.setLocationX(su.getLocationX());
                    su.setLocationY(su.getLocationY() + 1);
                } else {
                    bum = true;

                }

            }
        }
    }

    void start() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        listSU.add(new Pedestrian(r.nextInt(board.length), r.nextInt(board[0].length)));
        listSU.add(new Pedestrian(r.nextInt(board.length), r.nextInt(board[0].length)));
        listSU.add(new Pedestrian(r.nextInt(board.length), r.nextInt(board[0].length)));
        clear();
        createsVehicles();

        do {
            System.out.println("---------------------------------------------");
            clear();
            if (r.nextInt(4) == 0) {
                createPedestrian();
            }
            addToBoard();
            showStreet();
            move();
            off();


            if (bum == false) {
                bum = crash();
            }
            sc.nextLine();
        } while (!bum);


    }

}
