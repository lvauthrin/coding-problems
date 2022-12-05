workspace(name = "leetcode-python")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
http_archive(
    name = "rules_python_pytest",
    sha256 = "62c3b72e997743d1b3934348cadad7a0906efaa5139b24c39efa189fd3e2142d",
    strip_prefix = "rules_python_pytest-1.0.1",
    url = "https://github.com/caseyduquettesc/rules_python_pytest/archive/v1.0.1.tar.gz",
)

# Fetches the rules_python_pytest dependencies.
# If you want to have a different version of some dependency,
# you should fetch it *before* calling this.
# Alternatively, you can skip calling this function, so long as you've
# already fetched all the dependencies.
load("@rules_python_pytest//python_pytest:repositories.bzl", "rules_python_pytest_dependencies")
rules_python_pytest_dependencies()

load("@rules_python//python:pip.bzl", "pip_parse")
#
## Create a central repo that knows about the dependencies needed from
## requirements_lock.txt.
pip_parse(
   name = "my_deps",
   requirements_lock = "//python-external:requirements.txt",
)
# Load the starlark macro which will define your dependencies.
load("@my_deps//:requirements.bzl", "install_deps")
## Call it to define repos for your requirements.
install_deps()