@rem ===== 1. 빌드된 jar파일을 서버에 전송
scp -i "c:\git2021-working\gagym.pem" -r ./build/libs/sendReserve*.jar ubuntu@ec2-52-79-254-140.ap-northeast-2.compute.amazonaws.com:/home/ubuntu/app/gagym
@rem ===== 2. 기존 프로세스 종료
ssh -i "c:\git2021-working\gagym.pem" ubuntu@ec2-52-79-254-140.ap-northeast-2.compute.amazonaws.com "pkill -9 -f java"
@rem ===== 3. dev프로필로 jar 파일 실행
ssh -i "c:\git2021-working\gagym.pem" ubuntu@ec2-52-79-254-140.ap-northeast-2.compute.amazonaws.com "cd /home/ubuntu/app/gagym; nohup java -Dspring.profiles.active=dev -jar sendReserve*.jar 1>gagym.log 2>&1 &"