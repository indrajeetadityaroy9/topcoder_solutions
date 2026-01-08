set -euo pipefail

ROOT_DIR=$(cd "$(dirname "$0")/.." && pwd)
CPP_DIR="$ROOT_DIR/tests/cpp"
JAVA_DIR="$ROOT_DIR/tests/java"
BUILD_DIR="$ROOT_DIR/build"

mkdir -p "$BUILD_DIR/java"

# C++ tests
c++ -std=c++17 -O2 -o "$BUILD_DIR/CollectBoxesTest" "$CPP_DIR/CollectBoxesTest.cpp"
"$BUILD_DIR/CollectBoxesTest"

c++ -std=c++17 -O2 -o "$BUILD_DIR/SplitTest" "$CPP_DIR/SplitTest.cpp"
"$BUILD_DIR/SplitTest"

# Java tests
javac -d "$BUILD_DIR/java" "$ROOT_DIR"/*.java "$JAVA_DIR"/*.java
java -cp "$BUILD_DIR/java" RunAll
