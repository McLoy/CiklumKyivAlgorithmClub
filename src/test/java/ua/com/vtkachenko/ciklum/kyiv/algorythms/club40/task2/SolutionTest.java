package ua.com.vtkachenko.ciklum.kyiv.algorythms.club40.task2;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void solution() throws Exception {
        Solution s = new Solution();
        Assertions.assertThat(s.findPalindrom(1711)).isEqualTo(1771);
    }
}
