load("@pip//:requirements.bzl", "requirement")
load("@rules_python//python:defs.bzl", "py_library", "py_test")

def py_solution(**kwargs):
    data_name = "test/{name}.json".format(**kwargs)

    _generate_code(
        name = kwargs['name'],
        source_file = "test/{name}_test.py".format(**kwargs),
        template = kwargs['template'],
        data = data_name,
    )

    py_library_test(
      name = kwargs['name'],
      data = data_name,
    )

def py_library_test(name, data = None, deps = None, test_deps = None):
    src_label = "%s_src" % (name)
    src_name = "%s.py" % (name)

    py_library(
        name = src_label,
        srcs = [src_name],
        deps = deps,
    )

    updated_test_deps = [requirement("pytest"), src_label] + (test_deps if test_deps != None else [])

    py_test(
        name = "%s_test" % (name),
        srcs = ["test/%s_test.py" % (name)],
        deps = updated_test_deps,
        data = None if data == None else [data],
    )

def _generate_code_impl(ctx):
    ctx.actions.expand_template(
        template = ctx.file.template,
        output = ctx.outputs.source_file,
        substitutions = {
            "<SOLUTION_NAME>": ctx.label.name,
            "<DATA_NAME>": ctx.file.data.path,
        },
    )

_generate_code = rule(
    implementation = _generate_code_impl,
    attrs = {
        "template": attr.label(
            allow_single_file = True,
        ),
        "source_file": attr.output(mandatory = True),
        "data": attr.label(
            allow_single_file = True,
        ),
    },
)
