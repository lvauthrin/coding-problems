from time import time


def timing(func):
    # This function shows the execution time of
    # the function object passed
    def wrap_func(*args, **kwargs):
        t1 = time()
        result = func(*args, **kwargs)
        t2 = time()
        print(f'Function {func.__name__!r} executed in {(t2-t1):.4f}s')
        return result
    return wrap_func


def validate(expected, actual, message=None):
    if message is not None:
        assert expected == actual, message
    else:
        assert expected == actual
