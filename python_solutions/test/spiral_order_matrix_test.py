import sys
import pytest
from python_solutions import spiral_order_matrix


@pytest.mark.skip(reason="Need to implmement this still")
def test_nominal():
    assert (
        spiral_order_matrix.solve(
            [
                [1, 2, 3],
                [8, 9, 4],
                [7, 6, 5],
            ],
        )
        == "1, 2, 3, 4, 5, 6, 7, 8, 9"
    )


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
