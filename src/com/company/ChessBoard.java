package com.company;

public class ChessBoard {
    int size;
    int[][] b;
    int t = 1;

    ChessBoard() {
    }

    ;

    ChessBoard(int size) {
        this.size = size;
        b = new int[size][size];
    }

    public void fill(int tr, int tc, int dr, int dc, int size) {//tr,tc 0 0
        if (size == 1)
            return;
        int cover = t++;
        int s = size / 2;
        if (dr < tr + s && dc < tc + s) {
            fill(tr, tc, dr, dc, s);
        } else {
            b[tr + s - 1][tc + s - 1] = cover;
            fill(tr, tc, tr + s - 1, tc + s - 1, s);
        }

        if (dr < tr + s && dc >= tc + s) {
            fill(tr, tc + s, dr, dc, s);
        } else {
            b[tr + s - 1][tc + s] = cover;
            fill(tr, tc + s, tr + s - 1, tc + s, s);
        }

        if (dr >= tr + s && dc < tc + s) {
            fill(tr + s, tc, dr, dc, s);
        } else {
            b[tr + s][tc + s - 1] = cover;
            fill(tr + s, tc, tr + s, tc + s - 1, s);
        }

        if (dr >= tr + s && dc >= tc + s) {
            fill(tr + s, tc + s, dr, dc, s);
        } else {
            b[tr + s][tc + s] = cover;
            fill(tr + s, tc + s, tr + s, tc + s, s);
        }
    }


    public static void main(String[] args) {
        int size = 16;
        int dr = 7;
        int dc = 3;
        ChessBoard cb = new ChessBoard(size);
        cb.b[dr][dc] = 0;
        cb.fill(0, 0, 7, 3, size);
        new Chess(size, cb.b,dr,dc);
    }
}
