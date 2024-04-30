def solution(price):
    if 100000<=price<=299999:
        return (int)(price*0.95)
    elif 300000<=price<=499999:
        return (int)(price*0.9)
    elif price>=500000:
        return (int)(price*0.8)
    else:
        return price