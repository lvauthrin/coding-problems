load("@pip//:requirements.bzl", "requirement")
load("@rules_python//python:defs.bzl", "py_library", "py_test")

def py_library_test(name, deps = None, test_deps = None):
    py_library(
        name = name,
        srcs = ["%s.py" % (name)],
        deps = deps,
    )

    updated_test_deps = [requirement("pytest"), name] + (test_deps if test_deps != None else [])

    py_test(
        name = "%s_test" % (name),
        srcs = ["test/%s_test.py" % (name)],
        deps = updated_test_deps,
    )
