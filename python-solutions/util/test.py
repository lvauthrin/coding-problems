import time

def validate(expected, actual, message = None):
  if expected != actual:
    message_to_print = message if message is not None else f"'{expected}' does not equal '{actual}'"
    print(f"❌ {message_to_print}")
  else:
    print(f"✅ Received '{expected}'")

def timed_validate(expected, func, *args, **kwargs):
  t1 = time.perf_counter_ns()
  actual = func(*args, **kwargs)
  t2 = time.perf_counter_ns()
  total = round((t2 - t1) / 1000) # to milliseconds

  if expected != actual:
    message_to_print = f"'{expected}' does not equal '{actual}'"
    print(f"❌ {message_to_print} ({total}µs)")
  else:
    print(f"✅ Received '{expected} ({total}µs)'")
  