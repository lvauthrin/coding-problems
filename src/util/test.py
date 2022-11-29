
def validate(expected, actual, message = None):
  if expected != actual:
    message_to_print = message if message is not None else f"'{expected}' does not equal '{actual}'"
    print(f"❌ {message_to_print}")
  else:
    print(f"✅ Received '{expected}'")