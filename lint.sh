bazelisk run -- //tools/black $(pwd)/python_solutions && \
  bazelisk run -- //tools/autopep8 $(pwd)/python_solutions/**/*.py --in-place && \
  bazelisk run -- //tools/flake8 $(pwd)/python_solutions

