def solution(my_string):
    new=''
    for i in my_string:
        if i.isupper() == True:
            new+=i.lower()
        else:
            new+=i.upper()
    return new