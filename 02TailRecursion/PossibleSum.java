public class PossibleSum {

    public boolean isPossibleSum(int n, int target) {
	return help(n, target, 0);
    }

    private boolean help(int num, int goal, int sum) {
	if (goal == sum) {
	    return true;
	}

	if (num == 0) {
	    return false;
	}

	return help(num / 10, goal, sum) || help(num / 10, goal, sum + num % 10);
    }

}
