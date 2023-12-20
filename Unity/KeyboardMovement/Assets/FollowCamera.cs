using UnityEngine;

public class FollowCamera : MonoBehaviour
{
    public Transform objeto;
    public Vector3 offset = new Vector3(0f, 2f, -5f);

    // Update is called once per frame
    void Update()
    {
        if (objeto != null)
        {
            transform.position = objeto.position + offset;
        }
    }
}
