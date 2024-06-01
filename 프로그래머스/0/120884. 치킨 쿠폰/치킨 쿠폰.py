def solution(chicken): 
    coupons=chicken
    service=0
    while coupons >= 10:
        new_service = coupons // 10  
        service += new_service  
        coupons = coupons % 10 + new_service  

    return service
        
