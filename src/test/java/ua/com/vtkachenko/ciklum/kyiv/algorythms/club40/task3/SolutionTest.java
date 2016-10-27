package ua.com.vtkachenko.ciklum.kyiv.algorythms.club40.task3;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void solution() throws Exception {
        Solution s = new Solution();
        Assertions.assertThat(s.findPalindroms("abbacbb")).isEqualTo(3);
    }
}
