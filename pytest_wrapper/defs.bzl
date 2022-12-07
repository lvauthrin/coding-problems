# NOTE: adapted from https://dev.to/davidb31/experimentations-on-bazel-python-3-linter-pytest-49oh

load("@rules_python//python:defs.bzl", "py_test")
load("@pip//:requirements.bzl", "requirement")

def py_pytest_test(name, srcs, deps = [], args = [], **kwargs):
    py_test(
        name = name,
        srcs = [
            "//pytest_wrapper:pytest_wrapper.py",
        ] + srcs,
        main = "//pytest_wrapper:pytest_wrapper.py",
        args = [
            "-ra",
            "-vv",
        ] + args + ["$(location :%s)" % x for x in srcs],
        python_version = "PY3",
        srcs_version = "PY3",
        deps = deps + [
            requirement("pytest"),
            requirement("pytest-cov"),
            #requirement("coverage"),
        ],
        **kwargs
    )

