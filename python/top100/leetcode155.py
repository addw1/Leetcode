class MinStack:

    def __init__(self):
        self.eles = []
        self.min = []
        self.min_v = sys.maxsize
    def push(self, val: int) -> None:
        self.eles.append(val)
        if self.min_v >= val:
            self.min.append(val)
            self.min_v = val

    def pop(self) -> None:
        pop_ele = self.eles.pop()
        if self.min_v == pop_ele:
            self.min.pop()
            if len(self.min) != 0:
                self.min_v = self.min[-1]
            else:
                self.min_v = sys.maxsize


    def top(self) -> int:
        return self.eles[-1]

    def getMin(self) -> int:
        return self.min_v

