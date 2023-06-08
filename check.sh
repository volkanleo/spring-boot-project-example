dependency_updates=$(mvn versions:display-property-updates versions:display-parent-updates -DgenerateBackupPoms=false \
    | grep '\->' \
    | awk -F ' ' '{if ($2 != $4) print $0}')
message=""
if [ -z "$dependency_updates" ];
then
  message="✅ Congratulations, all your plugins have the latest releases! 🥳"
else
  dependency_updates=$(echo "$dependency_updates" | sed -E ':a;N;$!ba;s/\r{0,1}\n/\\n/g')
  countOutdated=$(echo "$dependency_updates" | wc -l)
  message="❌ **You have $countOutdated plugins with newer available releases:**\n$dependency_updates"
fi

curl \
  -X POST \
  "${{ github.event.pull_request.comments_url }}" \
  -H "Content-Type: application/json" \
  -H "Authorization: token ${{ secrets.PR_CHECK }}" \
  -d \
  "
  {
        \"body\": \"$message\"
  }
  "
