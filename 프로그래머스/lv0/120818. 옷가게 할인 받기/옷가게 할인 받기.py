def solution(price):
    answer = 0
    if price >= 500_000:
        return int(price - (price * 0.2))
    elif price >= 300_000:
        return int(price - (price * 0.1))
    elif price >= 100_000:
        return int(price - (price * 0.05))
    else:
        return price