package org.example.datastructuresandalgorithms.heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    public List<Integer> heaps;

    public Heap() {
        this.heaps = new ArrayList<>();
    }

    public void add(int value) {
        this.heaps.add(value);
    }   //  임시 메소드

    public void swap(int index1, int index2) {
        int temp = heaps.get(index1);
        heaps.set(index1, heaps.get(index2));
        heaps.set(index2, temp);
    }

    public int leftIndex(int index) {
        return (2 * index) + 1;
    }

    public int rightIndex(int index) {
        return (2 * index) + 2;
    }

    public int parentIndex(int index) {
        return (index - 1) / 2;
    }

    public void insert(int value) {
        heaps.add(value);
        int current = heaps.size() - 1;
        while (current > 0 && heaps.get(current) > heaps.get(parentIndex(current))) {
            int temp = parentIndex(current);
            if (heaps.get(temp) < heaps.get(current)) {
                swap(current, parentIndex(current));
                current = parentIndex(current);
            }
        }
    }

    public Integer remove() {
        if (heaps.isEmpty()) return null;
        if (heaps.size() == 1) return heaps.get(0);
        int answer = heaps.get(0);
        int current = heaps.size() - 1;
        heaps.set(0, heaps.get(current));   //  마지막 노드와 바꾼다.
        heaps.remove(current);
        sinkDown(0);
        return answer;
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftIndex(index);
            int rightIndex = rightIndex(index);
            if (leftIndex < heaps.size() && heaps.get(maxIndex) < heaps.get(leftIndex)) {
                maxIndex = leftIndex;
            }
            if (leftIndex < heaps.size() && heaps.get(maxIndex) < heaps.get(rightIndex)) {
                maxIndex = rightIndex;
            }
            if (maxIndex != index) {
                swap(maxIndex, index);
                index = maxIndex;
            } else {
                return;
            }   //  ToDO
        }
    }

    @Override
    public String toString() {
        return heaps.toString();
    }

    public void printHeapTree() {
        int n = heaps.size();
        int height = (int) Math.ceil(Math.log(n + 1) / Math.log(2));
        int currentIndex = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < Math.pow(2, i) && currentIndex < n; j++) {
                printSpaces((int) Math.pow(2, height - i - 1) - 1);
                System.out.print(heaps.get(currentIndex));
                printSpaces((int) Math.pow(2, height - i) - 1);
                currentIndex++;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    // 공백 출력을 위한 도우미 함수
    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }


}
